import {createRouter, createWebHashHistory} from 'vue-router'
import Login from '../views/LoginAndSignup/Login.vue'
import Frame from '@/views/Frame.vue'
import Home from '@/views/Home/Home.vue'
import SignUp from "@/views/LoginAndSignup/SignUp";
import Store from "@/views/store/Store";
import BuyInfo from "@/views/store/BuyInfo";
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
  {
    path: '/signup',
    name: 'SignUp',
    component: SignUp
  },
  {
    path: '/store',
    name: 'Store',
    component: Store
  },
  {
    path: '/buy',
    name: 'BuyInfo',
    component: BuyInfo
  }
  
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
