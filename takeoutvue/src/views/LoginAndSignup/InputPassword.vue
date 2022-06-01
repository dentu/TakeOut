<template>
    <div style="margin-top: 80px;">
        <div style="float: left; margin-bottom: 50px;">
            <div style="font-size: 20px;font-weight: bolder;">请输入密码</div>
        </div>
        <br style="clear:both;">
        <div style="margin-top: 20px;">
            <van-cell-group >
                <van-field
                      v-model="password"
                      placeholder="请输入密码"
                      type="password"
                      label="密码："
                      maxlength="15"
                />
            </van-cell-group>
        </div>
    </div>

</template>

<script>
export default {
    name: "InputPassword",
    data(){
        return{
            password:'',
        }
    }
}
</script>

<style scoped>

</style>