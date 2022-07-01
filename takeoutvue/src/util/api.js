import axios from "axios";
import {stringify} from 'qs';
import {KEY} from '../store'
export const API_URL = "http://localhost:81"
// // 全局的请求路径
axios.defaults.baseURL = API_URL

function processApiRequest(promise) {
    return new Promise(((resolve, reject) => {
        promise.then(ret => {
            if (ret.data && ret.data.code == 200) {
                resolve(ret.data);
            } else if (ret.data) {
                reject(ret.data.message)
            } else {
                reject(new Error('服务器响应的数据不正确'))
            }
        }).catch(err => {
            reject(new Error(err.message || err))
        })
    }))
}

/**
 * 接口操作
 * @param api
 * @param params
 * @returns {Promise<any>}
 */
export function get(api, setPort,params = {}) {
    axios.defaults.baseURL = "http://localhost:"+setPort // 重新设置端口号
    return processApiRequest(axios.get(api + '?' + stringify(params)))
}

export function post(api,setPort, params = {}, dataType = 'json') {
    axios.defaults.baseURL = "http://localhost:"+setPort // 重新设置端口号
    if (dataType == 'json') {
        return processApiRequest(axios.post(api, params));
    } else {
        return processApiRequest(axios.post(api, stringify(params), {
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            }
        }))
    }
}

export const request = axios.request


export default {
    get,
    post,
    request,
    API_URL,
}