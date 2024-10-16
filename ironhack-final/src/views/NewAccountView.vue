<script setup>
import { ref } from 'vue'
import router from '@/router'

const name = ref('')
const username = ref('')
const password = ref('')
const errorMessage = ref('')

const createUser = async () => {
  try {
    const response = await fetch('http://localhost:8080/api/users', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        name: name.value,
        username: username.value,
        password: password.value
      })
    })

    if (!response.ok) {
      const errorData = await response.json()
      throw new Error(errorData.message || 'Error creating account')
    }

    alert('Cuenta creada exitosamente')

    router.push('api/login')
  } catch (error) {
    errorMessage.value = error.message
  }
}
</script>

<template>
  <div class="register-form">
    <h2>Crea tu Cuenta:</h2>
    <div v-if="errorMessage" class="error">{{ errorMessage }}</div>
    <form @submit.prevent="createUser">
      <div>
        <label for="name">Nombre:</label>
        <input v-model="name" type="text" id="name" required />
      </div>
      <div>
        <label for="username">Nombre de usuario:</label>
        <input v-model="username" type="text" id="username" required />
      </div>
      <div>
        <label for="password">Contraseña:</label>
        <input v-model="password" type="password" id="password" required />
      </div>
      <button type="submit">Crear Cuenta</button>
    </form>
  </div>
</template>

<style scoped>
.register-form {
  max-width: 400px;
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
  text-shadow:
    -1px -1px 0 white,
    1px -1px 0 white,
    -1px 1px 0 white,
    1px 1px 0 white;
}

form div {
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
  background-color: #ac5c0c;
  color: #ecf0f1;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  margin-top: 20px;
}

button:hover {
  background-color: #8f3b0a;
}

input:focus {
  color: #ecf0f1;
  background-color: #34495e;
  outline: none;
}

.error {
  color: #e74c3c;
  margin-bottom: 10px;
  text-align: center;
}

@media (max-width: 630px) {
  .register-form {
    width: 50%;
  }

  h2 {
    font-size: 20px;
  }
}
</style>
