import axios from 'axios';

const instance = axios.create({
  // axios.create()는 axios 내부적으로 제공하는 속성
  // baseURL: 'http://localhost:3000/',
  baseURL: process.env.VUE_APP_API_URL, // 뷰에서 설정된 빌드 속성에 의해 env 파일을 설정하여 쉽게 불러 올 수 있도록 해줌
});

// function registerUser(userData) {
//   const url = 'http://localhost:3000/signup';
//   return axios.post(url, userData); // promise 리턴
// } // 일반적으로 await의 대상이 되는 비동기 처리 코드는 axios 등 프로미스를 반환하는 API 호출 함수

// signup api 요청 메서드
function registerUser(userData) {
  return instance.post('signup', userData);
} // 이 방법 추천

// login api 요청 메서드
function loginUser(userData) {
  return instance.post('login', userData);
}
export { registerUser, loginUser };
