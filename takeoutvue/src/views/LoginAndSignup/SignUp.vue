<template>
    <div>
<!--        进度条-->
        <div style="margin-top: -30px;">
            <van-steps :active="step" active-color="#38f">
                <van-step></van-step>
                <van-step></van-step>
                <van-step></van-step>
                <van-step></van-step>
            </van-steps>
        </div>
        <div style="width: 93%;margin: auto;">
            <!--        返回-->
            <div style="float: left; font-size: 20px; margin-top: 15px;" @click="this.$router.push('/login')">
                <van-icon name="arrow-left" />
            </div>
            <br style="clear:both;">
            <!--        显示-->
            <div>
                <van-tabs
                        v-model:active="step"
                        type="none"
                        :animated="true"
                        line-height="0px"
                        line-width="0px">
                    <van-tab> <InputAccount ref="InputAccount" /> </van-tab>
                    <van-tab> <input-email ref="InputEmail"/> </van-tab>
                    <van-tab> <input-nick-name ref="InputNickName"/> </van-tab>
                    <van-tab> <input-password ref="InputPassword"/></van-tab>
                </van-tabs>
            </div>
<!--            按钮-->
            <div style="margin-top: 25px;">
                <div v-if="step != 3">
                    <van-button round type="info" @click="onNext()" class="button_step">下一步</van-button>
                </div>
                <div v-if="step == 3">
                    <van-button round type="info" @click="submit()" class="button_step">注册</van-button>
                </div>
            </div>
        </div>

    </div>
</template>

<script>
import InputAccount from "@/views/LoginAndSignup/InputAccount";
import InputEmail from "@/views/LoginAndSignup/InputEmail";
import InputPassword from "@/views/LoginAndSignup/InputPassword";
import InputNickName from "@/views/LoginAndSignup/InputNickName";
import {Toast} from "vant";
import api from "@/util/api";
export default {
    name: "SignUp",
    components: {InputPassword, InputEmail, InputAccount,InputNickName},
    data(){
        return{
            step:0,
            userData:{
                account:'',
                password:'',
                email: '',
                nickName: '',
            },
        }
    },mounted()
    {
    },
    methods:{
        onNext()
        {
            if (this.step == 0) // 帐号
            {
                let acc = this.$refs.InputAccount.account
                if (acc == null || acc == "" || acc == 'undefined' || !acc || !/[^\s]/.test(acc)){
                    Toast.fail('请输入帐号!');
                    return;
                }else if (!/^[A-Za-z0-9]+$/.test(acc) || acc.length > 10 || acc.length < 6){
                    Toast.fail('帐号格式错误!');
                    return;
                }else {
                    this.userData.account = acc
                    this.step ++
                }
            }
            else if (this.step == 1)   // 邮箱
            {
                let reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
                let email = this.$refs.InputEmail.email
                if (email == null || email == "" || email == 'undefined' || !email || !/[^\s]/.test(email)){
                    Toast.fail('请输入邮箱!');
                    return;
                }else if (!reg.test(email) || email.length > 20 || email.length < 3){
                    Toast.fail('邮箱格式错误!');
                    return;
                }else { ``
                    this.userData.email = email
                    // 获取验证码对比
                    let token = this.$refs.InputEmail.token
                    if (token == null || token == "" || token == 'undefined' || !token || !/[^\s]/.test(token))
                    {
                        Toast.fail('请输入验证码!');
                        return;
                    }else {
                        // 验证验证码
                        api.post('/verifyCode',8012,{email: email ,token: token},'form').then(ret =>{
                            this.step ++
                        }).catch(error =>{
                            Toast.fail(error);
                        })
                    }
                }
            }
            // 昵称
            else if (this.step == 2)
            {
                let nick = this.$refs.InputNickName.nick
                if (nick == null || nick.length>6 || !/[^\s]/.test(nick)){
                    Toast.fail("昵称长度错误");
                    return;
                }
                // 去掉空格
                this.userData.nickName= nick.replace(/\s+/g,"");
                this.step ++
            }
        },
        submit() // 提交数据
        {
            if (this.step == 3) {
                let pawd = this.$refs.InputPassword.password
                if (pawd == null || pawd == "" || pawd == 'undefined' || !pawd || !/[^\s]/.test(pawd)) {
                    Toast.fail('请输入密码!');
                    return;
                } else if (!/^[A-Za-z0-9]+$/.test(pawd) || pawd.length > 15 || pawd.length < 6) {
                    Toast.fail('密码格式错误!');
                    return;
                } else {
                    this.userData.password = pawd
                    console.log(this.userData)
                    if (this.userData.password == "" || this.userData.account == "" || this.userData.email == "" || this.userData.nickName == "") {
                        this.step = 0;
                        this.clearUserData() // 清除数据
                    } else {
                        // 上传数据
                        api.post('/signup', 8012, this.userData).then(ret => {
                            Toast.success(ret.message)
                            this.$router.push("/login")
                        }).catch(error => {
                            Toast.fail(error);
                        })
                    }
                }
            }
        },
        clearUserData(){ //清除数据
            this.userData.email = ""
            this.userData.password = ""
            this.userData.account = ""
        }
    }
}
</script>

<style scoped>
.button_step{
    background: #1989fa;
    border:1px solid #1989fa;
    width: 200px;
    color: white;
    font-size: 16px;
}
</style>