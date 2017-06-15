import React from 'react';
import {browserHistory} from 'react-router';
import Translate from 'react-translate-component';
import TranslateProperty from '../common/translateproperty';
import LocalizedImage from '../common/localizedimage/localizedimage'
import request from '../../util/request'

require('es6-promise').polyfill();
require('array.prototype.find').shim();

export default class Userprofile extends React.Component {
  constructor(props) {
    super(props);
    this.state = {selectedStudyRight: this.props.valid_rights[0]};
  }

  static loadProps(params, cb) {
    let hasStorage = 'sessionStorage' in window && window.sessionStorage;
    let key = 'opiskeluoikeudet';
    let data = hasStorage ?
      sessionStorage.getItem(key) : null;

    if (hasStorage && data) {
      let now = new Date();
      let expiration = new Date(data.timestamp);
      expiration.setMinutes(expiration.getMinutes() + 15);
      if (now.getTime() > expiration.getTime()) {
        data = null;
        sessionStorage.removeItem(key);
      }
    }

    request('/api/opiskeluoikeudet/avop', {credentials: 'same-origin'})
      .then(study_rights => {
        const valid_rights = study_rights['valid'];
        const invalid_rights = study_rights['invalid'];
        const oppilaitos = study_rights['oppilaitos_id'];

        cb(null, {valid_rights, invalid_rights, oppilaitos})
      })
      .catch(e => {
        window.location = '/' + params.params.lang + '/error/' + (e.json.error)
      })
  }

  selectStudyRight(event) {
    this.setState({
      selectedStudyRight: this.props.valid_rights
        .find(x => x.id === event.target.value)
    });
  }

  onSubmit(event) {
    event.preventDefault();
    let data = {
      opiskeluoikeus_id: this.state.selectedStudyRight.id,
      oppilaitos_id: this.props.oppilaitos,
      kieli: this.props.params.lang
    };
    request('/api/rekisteroidy', {
      method: 'post',
      credentials: 'same-origin',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
    })
    .then(registration => window.location = registration['kysely-url'])
    .catch(e => {
      console.log("Virhe kyselyyn siirryttäessä: " + JSON.stringify(e))
      browserHistory.push(`/${this.props.params.lang}/error/${e.json.error}`)
    });
  }

  static headerImages() {
    return(
      <section id="theme">
        <div className="container">
          <div className="row">

            <div className="six columns">
              <div className="u-full-width">
                <div id="logo">
                  <LocalizedImage image="logo" />
                </div>
              </div>
            </div>

          </div>
        </div>
      </section>
    )
  }

  render() {
    if (this.props.valid_rights.length === 0) {
      return(
      <div>
        {Userprofile.headerImages()}
       <section id="no-rights">
        <div className="container">
          <div className="row">
            <div className="u-full-width"><Translate component="h4" content="opiskeluoikeus_errors.header"/></div>

            {((this.props.invalid_rights.length > 0) ?
              <div>
                <Translate {...{rights_count: this.props.invalid_rights.length}} component="p" content="opiskeluoikeus_errors.some_rights_contact_study_office" />

                {this.props.invalid_rights.map(r =>
                  <div> {r.koulutus.nimi[this.props.params.lang]} - <Translate component="text" content={'opiskeluoikeus_errors.'+r.virheet[0]}/></div>
                )}
              </div> :
            <Translate component="p" content="opiskeluoikeus_errors.no_rights_contact_study_office" />
            )}
            </div>
          </div>
         </section>
      </div>);
    }
    return (
      <div>
        {Userprofile.headerImages()}
        <section id="userprofile">
          <div className="container">
            <div className="row">
              <div className="u-full-width"><Translate component="h4" content="profiledata.header"/></div>
              <div className="u-full-width">
                {((this.state.selectedStudyRight.opiskeluoikeustyyppi === '3') ?
                <Translate component="p" content="profiledata.about_yamk" />
                : <Translate component="p" content="profiledata.about"/>)}
              </div>

              <form onSubmit={this.onSubmit.bind(this)}>
                {(this.props.valid_rights.length > 1) ?
                  <select onChange={this.selectStudyRight.bind(this)}
                          value={this.state.selectedStudyRight.id}>
                    {
                      this.props.valid_rights.map(sr =>
                        <TranslateProperty component="option"
                                           value={sr.id}
                                           data={sr.koulutus.nimi}>
                        </TranslateProperty>
                      )
                    }
                  </select>
                  : ''
                }
                <div className="u-full-width">
                  <table>
                    <tbody>
                    <tr>
                      <Translate component="td" content="profiledata.education"></Translate>
                      <TranslateProperty component="td"
                                         data={this.state.selectedStudyRight.koulutus.nimi}>
                      </TranslateProperty>
                    </tr>
                    <tr>
                      <Translate component="td" content="profiledata.school"></Translate>
                      <TranslateProperty component="td"
                                         data={this.state.selectedStudyRight.oppilaitos.nimi}>
                      </TranslateProperty>
                    </tr>
                    <tr>
                      <Translate component="td" content="profiledata.municipality"></Translate>
                      <TranslateProperty component="td"
                                         data={this.state.selectedStudyRight.kunta.nimi}>
                      </TranslateProperty>
                    </tr>
                    <tr>
                      <Translate component="td" content="profiledata.startYear"/>
                      <td>{this.state.selectedStudyRight.aloituspvm.year}</td>
                    </tr>
                    <tr>
                      <Translate component="td" content="profiledata.language"></Translate>
                      <td>{this.state.selectedStudyRight.kieli}</td>
                    </tr>

                    <tr className={this.state.selectedStudyRight.opiskeluoikeustyyppi === '3' ? 'hidden' : ''}>
                      <Translate component="td" content="profiledata.form_of_education"></Translate>
                      <Translate component="td"
                                 content={this.state.selectedStudyRight.koulutusmuoto == 0 ? 'profiledata.type.day' : 'profiledata.type.multi'}></Translate>
                    </tr>
                    </tbody>
                  </table>
                </div>
                <div className="u-full-width"><Translate component="p" content="profiledata.reminder"></Translate></div>
                <div className="u-full-width">
                  <button type="submit">
                    <Translate component="span" content="profiledata.submit"></Translate>
                  </button>
                </div>
                <div>
                  {(this.props.invalid_rights.length > 0 && this.props.valid_rights === 0) ?
                    <Translate {...{rights_count: this.props.invalid_rights.length}} component="p" content="opiskeluoikeus_errors.some_rights_contact_study_office" />
                    : ''
                  }
                </div>
              </form>
            </div>
          </div>
        </section>
      </div>
    )
  }

}
