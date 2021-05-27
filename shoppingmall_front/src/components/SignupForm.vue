<template>
  <form @submit.prevent="submitForm">
    <div>
      <label for="username">id : </label>
      <input id="username" type="text" v-model="username" />
    </div>
    <div>
      <label for="password">pw : </label>
      <input id="password" type="text" v-model="password" />
    </div>
    <div>
      <label for="nickname">nickname : </label>
      <input id="nickname" type="text" v-model="nickname" />
    </div>
    <button type="submit">회원 가입</button>
    <p>{{ logMessage }}</p>
  </form>
</template>

<script>
import { registerUser } from '@/api/index';

export default {
  data() {
    return {
      // form values
      username: ' ',
      password: ' ',
      nickname: ' ',
      // log
      logMessage: '',
    };
  },
  methods: {
    async submitForm() {
      // 먼저 함수의 앞에 async라는 예약어를 붙인다. 그러고 나서 함수의 내부 로직 중 http 통신을 하는 비동기 처리 코드 앞에 await를 붙인다.
      console.log('폼 제출'); // 여기서 주의해야 할 점은 비동기 처리 메서드가 꼭 프로미스 객체를 반환해야 await가 의도한 대로 동작한다.
      const userData = {
        username: this.username,
        password: this.password,
        nickname: this.nickname,
      };

      const { data } = await registerUser(userData); // http 통신을 하는 비동기 처리 코드를 담은 함수라서 await를 붙인다. registreUser는 비동기처리 메서드
      console.log(data.username); // 일반적으로 await의 대상이 되는 비동기 처리 코드는 axios 등 프로미스를 반환하는 API 호출 함수
      this.logMessage = `${data.username}님이 가입되었습니다`;
      this.initForm();
    },
    initForm() {
      //폼의 데이터를 비우는 함수
      this.username = '';
      this.password = '';
      this.nickname = '';
    },
  },
};
</script>

<style></style>
