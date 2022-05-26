import {createRouter, createWebHashHistory, createWebHistory, RouteRecordRaw} from 'vue-router'
import Login from '../views/Login/Login.vue'
import Frame from '@/views/Frame.vue'
import Home from '@/views/Home/Home.vue'
const routes = [
  {
    path: '/',
    name: 'frame',
	component: Frame,
	// children:[
		
	// ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login
  },
  
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
