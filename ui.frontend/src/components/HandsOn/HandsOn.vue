<script setup lang="ts">
import { ref } from 'vue'
import store from '../../store'

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
  fetch(`/bin/handson?query=${query}`)
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
    <div>
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

    <div>
      store: {{store.state.count}}
      <button @click="store.commit('increment')">
        Increment store
      </button>
    </div>

    </div>
</template>

<style scoped>
</style>
