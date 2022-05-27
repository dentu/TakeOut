import {createRouter, createWebHashHistory} from 'vue-router'
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
  history: createWebHashHistory(),
  routes
})

export default router
