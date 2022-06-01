<template>
    <div>
<!--        进度条-->
        <div style="margin-top: -30px;">
            <van-steps :active="step" active-color="#38f">
                <van-step></van-step>
                <van-step></van-step>
                <van-step></van-step>
            </van-steps>
        </div>
        <div style="width: 93%;margin: auto;">
            <!--        返回-->
            <div style="float: left; font-size: 20px; margin-top: 15px;">
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
                    <van-tab> <input-password ref="InputPassword"/></van-tab>
                </van-tabs>
            </div>
            <div style="margin-top: 25px;">
                <van-button round type="info" @click="onNext()" class="button_step">下一步</van-button>
            </div>
        </div>

    </div>
</template>

<script>
import InputAccount from "@/views/LoginAndSignup/InputAccount";
import InputEmail from "@/views/LoginAndSignup/InputEmail";
import InputPassword from "@/views/LoginAndSignup/InputPassword";
import {Toast} from "vant";
export default {
    name: "SignUp",
    components: {InputPassword, InputEmail, InputAccount},
    data(){
        return{
            step:1,
            userData:{
                account:'',
                password:'',
                email: ''
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
                }else {
                    this.userData.email = email
                    // 获取验证码对比
                    let token = this.$refs.InputEmail.token
                    if (token == null || token == "" || token == 'undefined' || !token || !/[^\s]/.test(token))
                    {
                        Toast.fail('请输入验证码!');
                        return;
                    }else {
                        this.step ++
                    }
                }
            }
            else if (this.step == 2)
            {

                this.userData.password = this.$refs.InputPassword.password
            }

            console.log(this.userData)
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