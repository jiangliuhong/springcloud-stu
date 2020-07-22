import Vue from "vue";
import VueRouter from "vue-router";

import home from "@/pages/home/index.vue";
import route from "@/pages/route/index.vue";

Vue.use(VueRouter);

const routes = [{
    path: "/",
    redirect: "/home"
}, {
    path: "/home",
    component: home
}, {
    path: "/route",
    component: route
}]

var router = new VueRouter({
    mode: 'hash',
    routes
})
export default router;