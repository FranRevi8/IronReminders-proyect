<script setup>
import { ref } from 'vue'
import router from '@/router'

const username = ref('')
const password = ref('')

const handleSubmit = async () => {
  if (username.value && password.value) {
    try {
      const url = `http://localhost:8080/api/login?username=${username.value}&password=${password.value}`

      const response = await fetch(url, {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json'
        }
      })

      if (response.ok) {
        const data = await response.json()
        const token = data.access_token
        console.log('Token recibido:', token)

        sessionStorage.setItem('authToken', token)

        router.push('/')
      } else {
        alert('Credenciales incorrectas. Prueba de nuevo.')
      }
    } catch (error) {
      console.error('Error en la autenticación:', error)
      alert('Error en la autenticación.')
    }
  } else {
    alert('Por favor, rellena ambos campos')
  }
}

const goToCreateAccount = () => {
  router.push('/new-account')
}
</script>

<template>
  <div class="bg">
    <div class="login-container">
      <h2>¡Bienvenido a IronReminders!</h2>
      <form @submit.prevent="handleSubmit">
        <div class="form-group">
          <label for="username">Usuario</label>
          <input
            v-model="username"
            type="text"
            id="username"
            required
            placeholder="Introduce tu usuario"
          />
        </div>

        <div class="form-group">
          <label for="password">Contraseña</label>
          <input
            v-model="password"
            type="password"
            id="password"
            required
            placeholder="Introduce tu contraseña"
          />
        </div>

        <button type="submit">Iniciar Sesión</button>
        <button @click="goToCreateAccount" class="new-acc-btn">Crear cuenta</button>
      </form>
    </div>
  </div>
</template>

<style scoped>
.bg {
  background-color: #34495e;
  height: 90vh;
}

.login-container {
  max-width: 400px;
  max-height: 550px;
  margin: 0 auto;
  padding: 20px;
  background-color: #d8e2e5;
  border-radius: 10px;
  box-shadow: 0px 8px 12px rgba(0, 0, 0, 0.3);
  position: relative;
  top: 200px;
  color: #34495e;
}

h2 {
  text-align: center;
  margin-bottom: 20px;
  padding: 15px;
  text-shadow:
    -1px -1px 0 white,
    1px -1px 0 white,
    -1px 1px 0 white,
    1px 1px 0 white;
}

.form-group {
  margin-bottom: 15px;
}

label {
  display: block;
  margin-bottom: 5px;
  font-weight: bold;
}

input {
  width: 100%;
  padding: 8px;
  box-sizing: border-box;
  border-radius: 5px;
  border: 1px solid #ccc;
  font-size: 14px;
  background-color: #34495e;
  color: #ecf0f1;
}

input::placeholder {
  color: #ecf0f1;
}

button {
  width: 100%;
  padding: 10px;
  background-color: #3498db;
  color: #ecf0f1;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  margin-top: 20px;
}

.new-acc-btn {
  background-color: #ac5c0c;
  margin-top: 10px;
}

button:hover {
  background-color: #2980b9;
}

.new-acc-btn:hover {
  background-color: #8f3b0a;
}

input:focus {
  color: #ecf0f1;
  background-color: #34495e;
  outline: none;
}

@media (max-width: 630px) {
  .login-container {
    width: 50%;
  }

  h2 {
    font-size: 20px;
  }
}
</style>
