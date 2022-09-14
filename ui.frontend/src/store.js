import Vuex from 'vuex'
import Vue from 'vue'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    count: 0,
    darkTheme: false
  },
  mutations: {
    increment (state) {
      state.count++
    },
    toggleTheme (state) {
      state.darkTheme = !state.darkTheme
    }
  }
})
