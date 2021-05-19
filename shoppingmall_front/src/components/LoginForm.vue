<template>
  <div>
    <div>login</div>
    <form @submit.prevent="submitForm">
      <div>
        <label for="username">id : </label>
        <input id="username" type="text" v-model="username" />
      </div>
      <div>
        <label for="password">pw : </label>
        <input id="password" type="text" v-model="password" />
      </div>
      <button type="submit">로그인</button>
      <p>{{ logMessage }}</p>
    </form>
  </div>
</template>

<script>
import { loginUser } from '@/api/index';
export default {
  data() {
    return {
      // form values
      username: ' ',
      password: ' ',
      // log
      logMessage: ' ',
    };
  },
  methods: {
    async submitForm() {
      const userData = {
        username: this.username,
        password: this.password,
      };
      const { data } = await loginUser(userData);
      console.log(data.user.username);
      this.logMessage = `${data.user.username} 님 환영합니다!`;
      this.initForm();
    },
    initForm() {
      this.username = '';
      this.password = '';
    },
  },
};
</script>

<style></style>
