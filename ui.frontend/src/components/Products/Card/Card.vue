<script setup lang="ts">
import store from '../../../store'

const props = defineProps({
  title: String,
  description: String,
  price: Number,
  thumb: String
})

</script>

<template>
  <div class="card">
      <img :src="props.thumb" :alt="props.title" />
      <div class="card-body">
      <div class="row">
          <div class="card-title">
              <h4>{{ props.title }}</h4>
              <h3>{{ props.price }}</h3>
          </div>
      </div>
      <hr />
      <p>{{ description }}</p>
      <div class="btn-group">
          <div class="btn">
              <button @click="store.commit('addProductInChart', {props})">+ Carrinho</button>
          </div>
          <div class="view-btn">
            <button>Detalhes</button>
          </div>
      </div>
      </div>
  </div>
</template>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;600;700&display=swap");
.card {
  width: 300px;
  min-height: 440px;
  border-radius: 5px;
  box-shadow: 0 4px 6px 0 rgba(0, 0, 0, 0.2);
  font-family: "Open Sans", sans-serif;
}
.card > *:not(img) {
  padding: 5px 10px;
}

.card img {
  width: 100%;
  height: 180px;
  object-fit: cover;
}

.card-body {
  padding: 20px;
}
.row {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.card-body p {
  color: #3d3d3d;
  margin-bottom: 20px;
  font-size: 14px;
}

.btn-group {
  display: flex;
  align-items: stretch;
  justify-content: flex-start;
  height: 40px;
  gap: 10px;
}

.view-btn button {
  height: 100%;
  padding: 0 15px;
  border: 1.5px solid #007bff;
  border-radius: 3px;
  text-decoration: none;
  color: #007bff;
}

.btn-group .btn button {
  width: 100px;
  height: 100%;
  background-color: #28a745;
  color: #fff;
  border-radius: 3px;
  border: none;
  cursor: pointer;
}
.btn-group a {
  margin: 0 10px;
  text-decoration: none;
  color: #000;
}
</style>
