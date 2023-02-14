<template>
    <div>
        <MailLogin></MailLogin>
        <VerifyCodeVue></VerifyCodeVue>
        <RoomControlVue></RoomControlVue>
    </div>
</template>
<script setup>
import MailLogin from '@/TUIRoom/components/RoomLogin/MailLogin.vue';
import VerifyCodeVue from '@/TUIRoom/components/RoomLogin/VerifyCode.vue';
import RoomControlVue from '@/TUIRoom/components/RoomHome/RoomControl.vue';
</script>