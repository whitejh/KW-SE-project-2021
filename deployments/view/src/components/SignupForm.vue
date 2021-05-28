<template>
  <div class="contents">
    <div class="form-wrapper form-wrapper-sm">
      <form class="form" @submit.prevent="submitForm">
        <div>
          <label for="username">아이디 </label>
          <input id="username" v-model="username" type="text" />
        </div>
        <div>
          <label for="password">비밀번호 </label>
          <input id="password" v-model="password" type="text" />
        </div>
        <div>
          <label for="name">이름 </label>
          <input id="name" v-model="name" type="text" />
        </div>
        <div>
          <label for="address">주소 </label>
          <input id="address" v-model="address" type="text" />
        </div>
        <div>
          <label for="phonenumber">전화번호 </label>
          <input id="phonenumber" v-model="phonenumber" type="text" />
        </div>
        <button type="submit" class="btn">회원 가입</button>
      </form>
      <p class="log">{{ logMessage }}</p>
    </div>
  </div>
</template>

<script>
import { registerUser } from '@/api/index';

export default {
  data() {
    return {
      // form values
      username: '',
      password: '',
      nickname: '',
      // log
      logMessage: '',
    };
  },
  methods: {
    async submitForm() {
      const userData = {
        username: this.username,
        password: this.password,
        nickname: this.nickname,
      };
      const { data } = await registerUser(userData);
      console.log(data.username);
      this.logMessage = `${data.username} 님이 가입되었습니다`;
      this.initForm();
    },
    initForm() {
      this.username = '';
      this.password = '';
      this.nickname = '';
    },
  },
};
</script>

<style scoped>
body {
  background: #f7f6f9;
}
.app {
  position: relative;
  width: 100%;
  height: 100%;
  font-size: 1.4rem;
}
.app-contents {
  height: calc(100% - 64px - 102px);
}
h1 {
  text-align: center;
  font-weight: 100;
}

/*--- LINK ---*/
a {
  color: #364f6b;
  text-decoration: none;
}
a:hover {
  color: #3fc1c9;
}

/*--- LAYOUT ---*/
.contents {
  max-width: 1020px;
  margin: 0 auto;
  padding: 0 5px;
  width: 100%;
}
/*--- HEADER ---*/
.page-header {
  font-size: 45px;
  font-weight: 600;
  color: #456155;
  padding: 30px 5px 15px;
}

/*--- FORM ---*/
.form-container {
  display: flex;
  align-items: center;
}
.form-wrapper {
  background: white;
  -webkit-box-shadow: 0 20px 20px rgba(0, 0, 0, 0.08);
  box-shadow: 0 20px 20px rgba(0, 0, 0, 0.08);
  border-radius: 3px;
  padding: 15px 15px;
}
.form-wrapper.form-wrapper-sm {
  max-width: 500px;
  margin: 40px auto;
}
.form-wrapper-sm .page-header {
  padding: 0px 0 20px;
}
.form {
  width: 460px;
  height: 100%;
}
.form .validation-text {
  margin-top: -0.5rem;
  margin-bottom: 0.5rem;
  font-size: 1rem;
  display: flex;
  flex-direction: row-reverse;
  justify-content: space-between;
}
.form label {
  width: 100%;
  display: block;
  margin-bottom: 0.5rem;
  color: #364f6b;
  font-size: 90%;
}
.form input,
.form textarea {
  font-family: inherit;
  font-size: 100%;
  width: 100%;
  border: 1px solid #dae1e7;
  box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.1);
  padding: 0.5rem 0.75rem;
  margin-bottom: 1rem;
}
.form input.valid {
  border: 1px solid #21b314;
}
.form input.invalid {
  border: 1px solid red;
}
.form div:nth-last-child(2) {
  margin-bottom: 0.5rem;
}
.btn {
  background: #fe9616;
  padding: 0.5rem 1.5rem;
  font-weight: 700;
  border-radius: 0.25rem;
  border: 0 solid #dae1e7;
}
.btn.disabled {
  opacity: 0.5;
  cursor: not-allowed;
}
.log {
  color: #ff4057;
  font-size: 1rem;
  text-align: center;
}
.warning {
  color: #ff4057;
}
html,
body {
  height: 100%;
  margin: 0;
  padding: 0;
  border: 0;
  font-size: 100%;
  font: inherit;
  vertical-align: baseline;
  font-family: 'Spoqa Han Sans', 'Sans-serif';
}

h1,
p,
ul {
  margin: 0;
  padding: 0;
}

input,
select,
textarea {
  border: 0;
  padding: 0;
  margin: 0;
  background: transparent;
  resize: none;
}

li {
  list-style: none;
}

button {
  font-family: inherit;
  font-size: 90%;
  margin: 0;
  cursor: pointer;
}

*,
*:after,
*:before {
  box-sizing: border-box;
  font-family: 'Spoqa Han Sans', 'Sans-serif';
}
</style>
