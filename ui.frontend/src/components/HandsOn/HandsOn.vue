<script setup lang="ts">
import { ref } from 'vue'

const props = defineProps({
  title: String
})

const count = ref(0)
const query = ref('')
const entries = ref(null)
const loading = ref(false)

function increment () {
  count.value++
}

function fetchEntries (query: string) {
  loading.value = true
  fetch(`https://api.publicapis.org/entries?title=${query}`)
    .then(response =>
      response.json()
        .then(data => {
          console.log(data.entries)
          entries.value = data.entries
          loading.value = false
        }
        )
    )
}
</script>

<template>
    <v-fragment>
    <h1>Hands On: {{props.title}}</h1>

    <button @click="increment">
        Count is: {{ count }}
    </button>

    <br/>

    <input placeholder="Buscar" type='text' v-model='query'/>

    <button @click="fetchEntries(query)">
        Enviar
    </button>

    <div v-if="loading">
        Carregando...
    </div>

    <div v-for="value in entries" :key="value['API']">
        <strong>{{ value['API'] }}:</strong> {{ value['Description'] }}
    </div>
    </v-fragment>
</template>

<style scoped>
</style>
