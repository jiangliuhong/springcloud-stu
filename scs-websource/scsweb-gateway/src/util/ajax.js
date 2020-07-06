import axios from 'axios'
import qs from 'qs'
import { Loading } from 'element-ui';

export default {
    /**
     * 打开遮罩
     */
    openLoading() {
        const loading = Loading.service({
            lock: true,
            text: 'Loading',
            spinner: 'el-icon-loading',
            background: 'rgba(0, 0, 0, 0.7)'
        });
        return loading;
    },
    /**
     * get请求
     * @param {String} url 
     * @param {Object} param 
     */
    get(url, param) {
        const loading = this.openLoading();
        return new Promise((resolve, reject) => {
            axios.get(url, qs.stringify(param)).then(res => {
                resolve(res.data);
                loading.close();
            }).catch(err => {
                reject(err);
                loading.close();
            })
        })
    },
    post(url, body) {
        const loading = this.openLoading();
        return new Promise((resolve, reject) => {
            axios.post(url, body).then(res => {
                resolve(res.data);
                loading.close();
            }).catch(err => {
                reject(err);
                loading.close();
            })
        })
    },
    put(url, body) {
        const loading = this.openLoading();
        return new Promise((resolve, reject) => {
            axios.put(url, body).then(res => {
                resolve(res.data);
                loading.close();
            }).catch(err => {
                reject(err);
                loading.close();
            })
        })
    },
    delete(url, param) {
        const loading = this.openLoading();
        return new Promise((resolve, reject) => {
            axios.delete(url, qs.stringify(param)).then(res => {
                resolve(res.data);
                loading.close();
            }).catch(err => {
                reject(err);
                loading.close();
            })
        })
    }
}