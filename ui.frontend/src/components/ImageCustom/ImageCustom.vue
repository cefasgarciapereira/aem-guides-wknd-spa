<script setup lang="ts">
import { onMounted } from 'vue'

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
 <div class="image-content">
   <h1>Vue Image Custom Component</h1>
   <img :src="props.src" :alt="props.alt" :title="props.title"/>
 </div>
</template>

<style scoped lang="scss">
.image-content {

 h1 {
   color: green;
 }

 img {
   height: 200px;
   border-radius: 10px;
 }
}
</style>
