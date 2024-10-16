<script setup>
import { ref } from 'vue'

const newReminder = ref({
  name: '',
  time: '',
  state: false,
  type: ''
})

const emit = defineEmits(['add-reminder', 'cancel-creation'])

const submitForm = () => {
  if (newReminder.value.time) {
    newReminder.value.time = new Date(newReminder.value.time).toISOString()
  }
  emit('add-reminder', { ...newReminder.value })
}

const cancelNew = () => {
  emit('cancel-creation')
}
</script>

<template>
  <form @submit.prevent="submitForm" class="new-reminder-form">
    <div class="input-group">
      <label for="type">Lista:</label>
      <input v-model="newReminder.type" type="text" id="type" required />
    </div>
    <div class="input-group">
      <label for="name">Recordatorio:</label>
      <input v-model="newReminder.name" type="text" id="name" required />
    </div>
    <div class="input-group">
      <label for="time">¿Cuándo?</label>
      <input v-model="newReminder.time" type="datetime-local" id="time" required />
    </div>
    <div class="button-group">
      <button type="submit" class="add-button">Añadir Recordatorio</button>
      <button type="button" @click="cancelNew" class="cancel-button">Cancelar</button>
    </div>
  </form>
</template>

<style scoped>
.new-reminder-form {
  background-color: #485c70;
  color: #ecf0f1;
  padding: 20px;
  margin: 20px auto;
  width: 75%;
  border-radius: 10px;
  box-shadow: 0px 8px 12px rgba(0, 0, 0, 0.3);
  display: flex;
  flex-direction: column;
}

.input-group {
  margin-bottom: 15px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

label {
  font-size: 1rem;
}

input {
  padding: 8px;
  border-radius: 5px;
  border: 1px solid #ffffff;
  background-color: #34495e;
  color: #ecf0f1;
  width: 70%;
  text-align: center;
}

input:focus {
  outline: none;
  background-color: #2c3e50;
  text-align: center;
}

.button-group {
  display: flex;
  justify-content: center;
}

.add-button {
  background-color: #3498db;
  color: #ecf0f1;
  border: none;
  padding: 10px;
  border-radius: 5px;
  cursor: pointer;
}

.cancel-button {
  background-color: #d92c2c;
  color: #ecf0f1;
  border: none;
  padding: 10px;
  border-radius: 5px;
  cursor: pointer;
  margin-left: 20px;
}

.add-button:hover {
  background-color: #2980b9;
}

.cancel-button:hover {
  background-color: #831212;
}

@media (max-width: 810px) {
  label {
    font-size: 12px;
  }

  input {
    font-size: 12px;
  }

  .add-button {
    font-size: 12px;
  }

  .cancel-button {
    font-size: 12px;
  }
}

@media (max-width: 630px) {
  label {
    font-size: 8px;
  }

  input {
    font-size: 8px;
    width: 60%;
  }

  .add-button {
    font-size: 8px;
  }

  .cancel-button {
    font-size: 8px;
  }
}
</style>
