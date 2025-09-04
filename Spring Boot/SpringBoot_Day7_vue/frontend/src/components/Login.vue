<template>
  <div class="container mt-5" style="max-width: 400px;">
    <div class="card shadow">
      <div class="card-body">
        <h3 class="card-title text-center mb-4">로그인</h3>

        <div v-if="loginMessage" class="alert alert-danger">{{ loginMessage }}</div>

        <form @submit.prevent="login">
          <div class="mb-3">
            <label for="loginUsername" class="form-label">아이디</label>
            <input type="text" id="loginUsername" class="form-control" v-model="loginUsername" required>
          </div>

          <div class="mb-3">
            <label for="loginPassword" class="form-label">비밀번호</label>
            <input type="password" id="loginPassword" class="form-control" v-model="loginPassword" required>
          </div>

          <button type="submit" class="btn btn-primary w-100">로그인</button>
        </form>

        <div class="mt-3">
          <p class="text-center">계정이 없으신가요? <a href="#" @click.prevent="toggleSignup">회원가입</a></p>
        </div>

        <div v-if="showSignup" class="mt-3">
          <h5 class="text-center">회원가입</h5>
          <div v-if="signupMessage" class="alert alert-success">{{ signupMessage }}</div>
          <form @submit.prevent="signup">
            <div class="mb-3">
              <label for="signupUsername" class="form-label">아이디</label>
              <input type="text" id="signupUsername" class="form-control" v-model="signupUsername" required>
            </div>
            <div class="mb-3">
              <label for="signupPassword" class="form-label">비밀번호</label>
              <input type="password" id="signupPassword" class="form-control" v-model="signupPassword" required>
            </div>
            <button type="submit" class="btn btn-success w-100">회원가입</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import axios from 'axios';

const loginUsername = ref('');
const loginPassword = ref('');
const loginMessage = ref('');

const signupUsername = ref('');
const signupPassword = ref('');
const signupMessage = ref('');

const showSignup = ref(false);

function toggleSignup() {
  showSignup.value = !showSignup.value;
}

// 로그인
const emitLogin = defineEmits(['login-success']);
const login = async () => {
  try {
    const res = await axios.post('http://localhost:8888/auth/login', {
      username: loginUsername.value,
      password: loginPassword.value
    });
    const token = res.data.token;
    emitLogin('login-success', token);
  } catch (err) {
    loginMessage.value = err.response?.data || '로그인 실패';
  }
};

// 회원가입
const signup = async () => {
  try {
    const res = await axios.post('http://localhost:8888/auth/signup', {
      username: signupUsername.value,
      password: signupPassword.value
    });
    signupMessage.value = res.data;
    signupUsername.value = '';
    signupPassword.value = '';
  } catch (err) {
    signupMessage.value = err.response?.data || '회원가입 실패';
  }
};
</script>
