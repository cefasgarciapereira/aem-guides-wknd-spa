<script setup lang="ts">
import { ref, onMounted } from 'vue'
import Card from './Card/Card.vue'
import store from '../../store'

type Product = {
    id: number;
    title: string;
    description?: string;
    price: number;
    discountPercentage?: number;
    rating?: string;
    stock: number;
    brand: string;
    category: string;
    thumbnail: string;
    images: Array<string>;
}

const products = ref<Array<Product>>([])
const loading = ref<boolean>(false)
const openChart = ref<boolean>(false)

function fetchProducts () {
  loading.value = true
  fetch('/bin/products')
    .then(response =>
      response.json()
        .then(data => {
          console.log(data.products)
          products.value = data.products
          loading.value = false
        }
        )
    )
}
function toggleOpenChart () {
  openChart.value = !openChart.value
}

function saveCart () {
  window.sessionStorage.setItem('@cart', JSON.stringify(store.state.cartItems))
}

onMounted(() => fetchProducts())
</script>

<template>
  <div>
    <button @click="toggleOpenChart()">
      🛍️ {{ store.state.cartItems.length}} {{openChart ? "esconder" :  "mostrar"}}
    </button>
    <button @click="saveCart()">
      Salvar carrinho
    </button>
    <button @click="store.commit('loadCart')">
      Carregar carrinho
    </button>
    <div class="chart" v-if="openChart">
        <Card
          v-for="product in store.state.cartItems"
          :key="product.id"
          :title="product.title"
          :description="product.description"
          :price="product.price"
          :thumb="product.thumb"
        />
    </div>
    <div class="container">
        <Card
          v-for="product in products"
          :key="product.id"
          :title="product.title"
          :description="product.description"
          :price="product.price"
          :thumb="product.thumbnail"
        />
    </div>
  </div>
</template>

<style scoped>
.chart{
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-gap: 20px;
  background-color: #f4f4f4;
  margin: 20px 0;
}
.container{
  display: grid;
  grid-template-columns: 1fr;
  grid-gap: 20px;
}

@media (min-width: 768px) {
  .container{
    grid-template-columns: 1fr 1fr 1fr 1fr;
  }
}

@media (min-width: 1280) {
  .container{
    grid-template-columns: 1fr 1fr 1fr;
  }
}

@media (min-width: 1900) {
  .container{
    grid-template-columns: 1fr 1fr 1fr 1fr;
  }
}
</style>
