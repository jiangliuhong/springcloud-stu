import axios from 'axios'
import qs from 'qs'

export default {
    /**
     * get请求
     * @param {String} url 
     * @param {Object} param 
     */
    get(url, param) {
        return new Promise((resolve, reject) => {
            axios.get(url, qs.stringify(param)).then(res => {
                resolve(res);
            }).catch(err => {
                reject(err);
            })
        })
    }
}