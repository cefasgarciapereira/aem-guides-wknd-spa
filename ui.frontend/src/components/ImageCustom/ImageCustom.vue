<script setup lang="ts">
import { onMounted } from 'vue'
import store from '../../store'

const props = defineProps({
  src: String,
  alt: String,
  title: String
})

onMounted(() => {
  console.info(`The props is ${props.src} ${props.alt} ${props.title}`)
})
</script>

<template>
 <div :class="[`${store.state.darkTheme ? 'dark-' : ''}image-content`]">
   <h1>Vue Image Custom Component</h1>
   <img :src="props.src" :alt="props.alt" :title="props.title"/>
 </div>
</template>

<style scoped lang="scss">

.dark-image-content{
  background-color: black;
  color: white;

  img {
    height: 200px;
    border-radius: 10px;
  }
}
.image-content {
  background-color: white;
  color: black;

  img {
    height: 200px;
    border-radius: 10px;
  }
}
</style>
