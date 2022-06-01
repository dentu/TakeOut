<template>
    <div style="margin-top: 80px;">
        <div style="float: left;margin-bottom: 50px;">
            <div style="font-size: 20px;font-weight: bolder;">请输入帐号</div>
        </div>
        <br style="clear:both;">
        <div style="float: left;">
            <div style="margin-bottom: 6px;">
                <span style="color: red;padding-right: 3px;">*</span>
                <span style="font-size: 13px;">帐号是由数字和字母组成,且在6～10位数之间</span>
            </div>
        </div>
        <span style="clear:both;"></span>
        <div style="margin-top: 20px;">
            <van-cell-group>
                <van-field
                      v-model="account"
                      placeholder="请输入帐号"
                      label="帐号："
                      maxlength="10"
                      style="border-bottom: 1px solid rgb(198 199 199 / 60%)"
                />
            </van-cell-group>
        </div>
    </div>
</template>

<script>
export default {
    name: "InputAccount",
    data() {
        return {
            account: '',
            tips: '',
        }
    },
    mounted() {
    },
    methods:{

    }
}
</script>

<style scoped>

</style>