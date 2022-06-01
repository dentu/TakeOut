import {createRouter, createWebHashHistory} from 'vue-router'
import Login from '../views/LoginAndSignup/Login.vue'
import Frame from '@/views/Frame.vue'
import Home from '@/views/Home/Home.vue'
import SignUp from "@/views/LoginAndSignup/SignUp";
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
  }
  
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
