import Vuex from 'vuex'
import Vue from 'vue'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    count: 0,
    cartItems: [],
    darkTheme: false
  },
  mutations: {
    increment (state) {
      state.count++
    },
    toggleTheme (state) {
      state.darkTheme = !state.darkTheme
    },
    addProductInChart (state, payload) {
      state.cartItems.push({ ...payload.props })
    },
    loadCart (state) {
      state.cartItems = JSON.parse(window.sessionStorage.getItem('@cart'))
    }
  }
})
