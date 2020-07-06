import Vue from 'vue'
import App from './App.vue'

import router from "./router.js"

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

import ajax from './util/ajax.js';
import config from './util/config';


Vue.use(ElementUI)

Vue.prototype.ajax = ajax;
Vue.prototype.config = config;



Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
