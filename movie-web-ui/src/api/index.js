import http from './public'
// 极验验证码
export const geeTest = (params) => {
    return http.fetchGet('/api/member/geeTestInit?t=' + (new Date()).getTime(), params)
}
// 登陆
export const memberLogin = (params) => {
    return http.fetchPost('/api/member/login', params)
}
