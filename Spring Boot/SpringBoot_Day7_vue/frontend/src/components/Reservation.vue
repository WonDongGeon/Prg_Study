<template>
    <div class="container mt-5" style="max-width: 600px;">
      <div class="d-flex justify-content-between align-items-center mb-3">
        <h3>좌석 예약</h3>
        <button class="btn btn-danger" @click="logout">로그아웃</button>
      </div>
  
      <div class="input-group mb-3">
        <input type="text" class="form-control" placeholder="이름 입력" v-model="userName">
        <input type="text" class="form-control" placeholder="좌석 번호 입력" v-model="seatNo">
        <button class="btn btn-primary" @click="reserve">예약</button>
      </div>
  
      <h5>예약 현황</h5>
      <ul class="list-group">
        <li class="list-group-item" v-for="r in reservations" :key="r.id">
          {{ r.seatNo }} - {{ r.userName }}
        </li>
      </ul>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  import axios from 'axios';
  
  const userName = ref('');
  const seatNo = ref('');
  const reservations = ref([]);
  let eventSource = null;
  
  const fetchReservations = async () => {
    const token = localStorage.getItem('access_token');
    if (!token) return;
  
    try {
      const res = await axios.get('http://localhost:8888/api/reservations', {
        headers: { Authorization: 'Bearer ' + token }
      });
      reservations.value = res.data;
    } catch (err) {
      console.error(err);
    }
  };
  
  const reserve = async () => {
  const token = localStorage.getItem('access_token');
  if (!token) return alert('로그인이 필요합니다.');

  try {
    await axios.post('http://localhost:8888/api/reservations', {
      userName: userName.value,
      seatNo: seatNo.value
    }, {
      headers: { Authorization: 'Bearer ' + token }
    });
    userName.value = '';
    seatNo.value = '';
    // reservations.value.push(res.data); ← 제거
  } catch (err) {
    alert(err.response?.data || err.message);
  }
};
  
  const subscribeSSE = () => {
    const token = localStorage.getItem('access_token');
    if (!token) return;
  
    eventSource = new EventSource(`http://localhost:8888/api/reservations/subscribe?token=${token}`);
    eventSource.addEventListener('reservation', event => {
      const data = JSON.parse(event.data);
      reservations.value.push(data);
    });
    eventSource.onerror = () => {
      eventSource.close();
      eventSource = null;
    };
  };
  
  const logout = () => {
    localStorage.removeItem('access_token');
    if (eventSource) {
      eventSource.close();
      eventSource = null;
    }
    location.reload();
  };
  
  onMounted(() => {
    fetchReservations();
    subscribeSSE();
  });
  </script>
  