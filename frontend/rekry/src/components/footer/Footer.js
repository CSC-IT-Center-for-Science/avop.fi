require('./footer.scss');

import React from 'react';
import Translate from 'react-translate-component';
import LocalizedImage from '../common/localizedimage/localizedimage';

let arene_logo = require('../../images/arene.png');

let Footer = () =>
  <footer className="container">
    <div className="row">
      <div className="u-full-width">
        <Translate component="h4" content="footer.header"/>
      </div>

    </div>
    <div className="row">
      <div className="one-third column okm">
        <LocalizedImage image="OKM_logo" />
      </div>

      <div className="one-third column csc">
        <LocalizedImage image="CSC" />
      </div>
    </div>

    <div className="row">
      <div className="one-third column">
        <Translate component="p" content="footer.okm.description"/>
      </div>
      <div className="one-third column">
        <Translate component="div" content="footer.csc.description"/>
        <span>arvo@postit.csc.fi</span>
      </div>
    </div>

  </footer>;

export default Footer;