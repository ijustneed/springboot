import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/Manager.vue'
import Manager from "@/views/Manager";
import store from "@/store";

Vue.use(VueRouter)

const routes = [

  {path: "/login",name: "login", component: () => import("../views/Login")},

  {
    path: "/register",name: "register", component: () => import ("../views/Register")
  },
  {
    path: "/404",name: "404", component: () => import ("../views/404")
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})
export const setRoutes = () => {
  const storeMenus = localStorage.getItem("menus")
  if (storeMenus) {

    const currentRouteNames = router.getRoutes().map(v => v.name)
    const manageRoute= {path:'/',component: () => import("../views/Manager"), redirect: "/home" ,children: [
        {path:'person',name:"个人信息",component: () => import("../views/Person")}
      ]}
    const menus = JSON.parse(storeMenus)
    menus.forEach(item => {
      if (item.path){
        let itemMenu = {path: item.path.replace("/",""),name:item.name, component: () => import('../views/' +item.pagePath+'.vue')}
        manageRoute.children.push(itemMenu)
      }else if (item.children.length) {
        item.children.forEach(item =>{
          if (item.path){
            let itemMenu = {path: item.path.replace("/",""),name:item.name, component: () => import('../views/' +item.pagePath+'.vue')}
            manageRoute.children.push(itemMenu)
          }

        })
      }

    })
    if(!currentRouteNames.includes('Manage')){
      router.addRoute(manageRoute)

    }
  }
}
setRoutes()

// router.addRoute(  {
//   path: '/',
//   name: 'manager',
//   component: () => import('../views/Manager'),
//   redirect: "/home",
//   children:[
//     {
//       path: "home", name: "首页",component: () => import("../views/Home")
//     },{
//       path: "user",name:"用户管理",component: () => import("../views/User")
//     },
//     {
//       path: "role",name:"角色管理",component: () => import("../views/Role")
//     },
//     {
//       path: "menu",name:"菜单管理",component: () => import("../views/Menu")
//     },
//     {
//       path: "person",name: "个人信息", component: () => import ("../views/Person")
//     },
//     {
//       path: "file",name: "文件管理", component: () => import ("../views/File")
//     },
//
//   ]
//
// },)

export const resetRouter = () => {
  router.matcher = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
  })
}


// 路由守卫
router.beforeEach((to, from, next) => {
  localStorage.setItem("currentPathName", to.name)  // 设置当前的路由名称，为了在Header组件中去使用
  store.commit("setPath")  // 触发store的数据更新
  const storeMenus = localStorage.getItem("menus")
  if (!to.matched.length) {
    if (storeMenus) {
      // 放行路由
      next("404")
    }else {
      next("/login")
    }


  }
  next()

})


export default router
