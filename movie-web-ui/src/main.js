import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
import {userInfo} from './api'
import {getStore} from './utils/storage'

import 'element-ui/lib/theme-chalk/index.css'
import './plugins/element.js'

Vue.config.productionTip = false
Vue.use(ElementUI)
//Vue.prototype.$message = ElementUI.Message;
const whiteList = ['/home',] // 不需要登陆的页面
// router.beforeEach(function (to, from, next) {
//     let params = {
//         params: {
//             token: getStore('token')
//         }
//     }
//     userInfo(params).then(res => {
//         if (res.status == 500) { // 没登录
//             if (whiteList.indexOf(to.path) !== -1) { // 白名单
//                 next()
//             } else {
//                 next('/login')
//             }
//         }
//     })
// })
new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')
