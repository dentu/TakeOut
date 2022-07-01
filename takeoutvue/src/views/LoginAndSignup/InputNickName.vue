<template>
    <div style="margin-top: 80px;">
        <div style="float: left;margin-bottom: 50px;">
            <div style="font-size: 20px;font-weight: bolder;">请输入昵称</div>
        </div>
        <br style="clear:both;">
        <div style="float: left;">
            <div style="margin-bottom: 6px;">
                <span style="color: red;padding-right: 3px;">*</span>
                <span style="font-size: 13px;">昵称长度在1~6位数</span>
            </div>
        </div>
        <span style="clear:both;"></span>
        <div style="margin-top: 20px;">
            <van-cell-group>
                <van-field
                      v-model="nick"
                      placeholder="请输入昵称"
                      label="昵称："
                      maxlength="6"
                      minlength="1"
                      style="border-bottom: 1px solid rgb(198 199 199 / 60%)"
                />
            </van-cell-group>
        </div>
    </div>
</template>

<script>
export default {
    name: "InputNickName",
    data() {
        return {
            nick: '',
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