<template>
  <room
    ref="TUIRoomRef"
    @on-log-out="handleLogOut"
    @on-create-room="onCreateRoom"
    @on-enter-room="onEnterRoom"
    @on-destroy-room="onDestroyRoom"
    @on-exit-room="onExitRoom"
    @on-kicked-out-of-room="onKickedOutOfRoom"
    @on-kick-off-line="onKickedOffLine"
    @on-user-sig-expired="onUserSigExpired"
  ></room>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue';
import Room from '@/TUIRoom/index.vue';
import { useRoute } from 'vue-router';
import router from '@/router';
import { checkNumber } from '@/TUIRoom/utils/common';
import { useI18n } from 'vue-i18n';
import { ElMessageBox } from 'element-plus';
const { t } = useI18n();

const route = useRoute();

const roomInfo = sessionStorage.getItem('tuiRoom-roomInfo');
const userInfo = sessionStorage.getItem('tuiRoom-userInfo');

const roomId = checkNumber((route.query.roomId) as string) ? route.query.roomId : '';

if (!roomId) {
  router.push({ path: 'home' });
} else if (!roomInfo) {
  router.push({ path: 'home', query: { roomId } });
}

const TUIRoomRef = ref();

onMounted(async () => {
  const { action, roomMode, roomParam } = JSON.parse(roomInfo as string);
  const { sdkAppId, userId, userSig, userName, avatarUrl } = JSON.parse(userInfo as string);
  try {
    await TUIRoomRef.value?.init({
      sdkAppId,
      userId,
      userSig,
      userName,
      avatarUrl,
    });
    if (action === 'createRoom') {
      try {
        await TUIRoomRef.value?.createRoom({ roomId, roomName: roomId, roomMode, roomParam });
      } catch (error: any) {
        const message = t('Failed to enter the room.') + error.message;
        ElMessageBox.alert(message, t('Note'), {
          customClass: 'custom-element-class',
          confirmButtonText: t('Confirm'),
          callback: () => {
            router.replace({ path: 'home' });
          },
        });
      }
    } else if (action === 'enterRoom') {
      try {
        await TUIRoomRef.value?.enterRoom({ roomId, roomParam });
      } catch (error: any) {
        const message = t('Failed to enter the room.') + error.message;
        ElMessageBox.alert(message, t('Note'), {
          customClass: 'custom-element-class',
          confirmButtonText: t('Confirm'),
          callback: () => {
            router.replace({ path: 'home' });
          },
        });
      }
    }
  } catch (error: any) {
    const message = t('Failed to enter the room.') + error.message;
    ElMessageBox.alert(message, t('Note'), {
      customClass: 'custom-element-class',
      confirmButtonText: t('Confirm'),
      callback: () => {
        sessionStorage.removeItem('tuiRoom-currentUserInfo');
        router.replace({ path: 'home' });
      },
    });
  }
});

/**
 * Processing users click [Logout Login] in the upper left corner of the page
 * ???????????????????????????????????????????????????
**/
function handleLogOut() {
/**
 * The accessor handles the logout method
 * ??????????????? logout ??????
**/

console.log("onLogOut");
router.replace({
  path: 'login',
  
})
}

/**
 * Hosts create room callbacks
 * ???????????????????????????
**/
function onCreateRoom(info: { code: number; message: string }) {
  console.debug('onEnterRoom:', info);
}

/**
 * Ordinary members enter the room callback
 * ??????????????????????????????
**/
function onEnterRoom(info: { code: number; message: string }) {
  console.debug('onCreateRoom:', info);
}

/**
 * Hosts destroy room callbacks
 * ???????????????????????????
**/
const onDestroyRoom = (info: { code: number; message: string }) => {
  console.debug('onDestroyRoom:', info);
  sessionStorage.removeItem('tuiRoom-roomInfo');
  router.replace({ path: '/home' });
};

/**
 * Ordinary members exit the room callback
 * ??????????????????????????????
**/
const onExitRoom = (info: { code: number; message: string }) => {
  console.debug('onExitRoom:', info);
  sessionStorage.removeItem('tuiRoom-roomInfo');
  router.replace({ path: '/home' });
};

/**
 * Ordinary members were kicked out of the room by the host
 * ????????????????????????????????????
**/
const onKickedOutOfRoom = (info: { roomId: string; message: string }) => {
  console.debug('onKickedOutOfRoom:', info);
  sessionStorage.removeItem('tuiRoom-roomInfo');
  router.replace({ path: '/home' });
};

/**
 * Users are kicked offline
 * ????????????
 */
const onKickedOffLine = (info: { message: string }) => {
  console.debug('onKickedOffLine:', info);
  sessionStorage.removeItem('tuiRoom-roomInfo');
  router.replace({ path: '/home' });
};

/**
 * Ordinary members were kicked out of the room by the host
 * userSig ??????????????????????????? userSig
 */
const onUserSigExpired = () => {
  console.debug('onUserSigExpired');
  sessionStorage.removeItem('tuiRoom-roomInfo');
  sessionStorage.removeItem('tuiRoom-currentUserInfo');
  router.replace({ path: '/home' });
};
</script>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #B3B8C8;
  position: relative;
  width: 100%;
  height: 100%;
}
</style>
