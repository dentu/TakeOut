<template>
    <div style="margin-top: 80px;">
        <div style="float: left;margin-bottom: 50px;">
            <div style="font-size: 20px;font-weight: bolder;">请输入邮箱</div>
        </div>
        <br style="clear:both;">
        <div style="margin-top: 20px;">
            <van-cell-group inset>
                <van-field v-model="email" label="邮箱:" placeholder="请输入邮箱" />
                <van-field
                      v-model="token"
                      center
                      clearable
                      type="number"
                      label="短信验证码:"
                      maxlength="20"
                      placeholder="请输入短信验证码"
                      style="margin-top: 10px;"
                >
                    <template #button>
                        <van-button size="small" :disabled="showDisabled" type="primary" @click="sendCode()">{{time}}发送验证码</van-button>
                    </template>
                </van-field>
            </van-cell-group>
        </div>
    </div>
</template>

<script>
export default {
    name: "InputEmail",
    data(){
        return{
            email:'',
            token:'',
            showDisabled: false,
            time:''
        }
    },
    mounted() {
    },
    methods:{
        sendCode(){ // 发送验证码
            this.time = 60;
        }
    }
}
</script>

<style scoped>
.van-cell-group--inset{
    margin: unset;
}

</style>
<style>
.van-field__label{
    width: unset !important;
}
</style>