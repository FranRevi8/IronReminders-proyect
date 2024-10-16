<script setup>
import { defineProps, ref } from 'vue'

const props = defineProps({
  id: Number,
  name: String,
  time: String,
  type: String,
  state: Boolean
})

const emit = defineEmits(['completed-toggle', 'delete', 'update'])

const isCompleted = () => {
  emit('completed-toggle')
}

const deleteReminder = () => {
  emit('delete')
}

const isEditing = ref(false)
const editedName = ref(props.name)
const editedTime = ref(props.time)
const editedType = ref(props.type)

const enableEditing = () => {
  isEditing.value = true
}

const saveChanges = () => {
  isEditing.value = false
  emit('update', {
    id: props.id,
    name: editedName.value,
    time: editedTime.value,
    type: editedType.value
  })
}
</script>

<template>
  <div class="reminder-card">
    <ul class="reminder-content">
      <li class="type">
        <span v-if="!isEditing" class="list-title">Lista:</span>
        <br v-if="!isEditing" />
        <span v-if="isEditing">
          <input v-model="editedType" />
        </span>
        <span v-else>{{ props.type }}</span>
      </li>
      <li class="name">
        <span v-if="isEditing">
          <input v-model="editedName" />
        </span>
        <span v-else>{{ props.name }}</span>
      </li>
      <li class="time">
        <span v-if="isEditing">
          <input v-model="editedTime" type="datetime-local" />
        </span>
        <span v-else>{{ new Date(props.time).toLocaleString() }}</span>
      </li>
      <li class="state">
        <span v-if="props.state" class="done">¡Completado!</span>
        <span v-else class="not-done">No completado</span>
      </li>
      <li class="complete-btn-cont">
        <button
          @click="isCompleted"
          :class="{ 'complete-btn': !props.state, 'incomplete-btn': props.state }"
        >
          <span v-if="props.state">❎</span>
          <span v-else>✅</span>
        </button>
      </li>
      <li class="modify-btn-cont">
        <button v-if="isEditing" @click="saveChanges" class="save-changes-btn">Guardar</button>
        <button v-else @click="enableEditing">🔄</button>
      </li>
      <li class="delete-btn-cont">
        <button @click="deleteReminder" class="delete-btn">🗑️</button>
      </li>
    </ul>
  </div>
</template>

<style scoped>
.reminder-card {
  background-color: #485c70;
  color: #ecf0f1;
  padding: 15px;
  margin: 20px auto;
  width: 90%;
  border-radius: 10px;
  box-shadow: 0px 8px 12px rgba(0, 0, 0, 0.3);
  height: 70px;
}

ul {
  display: flex;
  justify-content: space-evenly;
  align-items: center;
  padding: 0;
  margin: 0;
}

li {
  list-style-type: none;
}

.type {
  flex-direction: column;
  width: 10%;
  text-align: center;
  text-transform: capitalize;
  line-height: 28px;
}

.list-title {
  color: #a2bed1;
}

.name {
  width: 10%;
  text-align: center;
}

.time {
  width: 10%;
  text-align: center;
  line-height: 30px;
}

.state {
  width: 10%;
  text-align: center;
}

.done {
  color: rgb(105, 209, 105);
}

.not-done {
  color: rgb(228, 228, 59);
}

.complete-btn-cont {
  width: 2%;
}

.modify-btn-cont {
  width: 2%;
}
.delete-btn-cont {
  width: 1%;
}

button {
  background-color: #485c70;
  color: #ecf0f1;
  border: none;
  padding: 8px 8px;
  border-radius: 5px;
  cursor: pointer;
  font-size: 30px;
}

button:hover {
  background-color: #2980b9;
}

.save-changes-btn {
  font-size: 12px;
  background-color: #3096da;
}

input {
  padding: 5px;
  border-radius: 5px;
  border: 1px solid #ecf0f1;
  background-color: #34495e;
  color: #ecf0f1;
  height: 42px;
  width: 7vw;
  text-align: center;
  font-size: 12px;
}

.delete-btn {
  background-color: #485c70;
}

.delete-btn:hover {
  background-color: rgb(173, 54, 54);
}

.complete-btn {
  background-color: #485c70;
  font-size: 30px;
  color: #4d6c81;
}

.complete-btn:hover {
  background-color: rgb(95, 188, 95);
}

.incomplete-btn {
  background-color: #485c70;
  font-size: 30px;
  color: #4d6c81;
}

.incomplete-btn:hover {
  background-color: rgb(192, 192, 64);
}

input:focus {
  outline: none;
  background-color: #2c3e50;
  text-align: center;
}

@media (max-width: 1036px) {
  button {
    font-size: 20px;
  }

  .complete-btn {
    font-size: 20px;
  }
  .incomplete-btn {
    font-size: 20px;
  }

  .save-changes-btn {
    font-size: 10px;
  }

  input {
    font-size: 10px;
  }
}

@media (max-width: 810px) {
  button {
    font-size: 16px;
  }

  .complete-btn {
    font-size: 16px;
  }
  .incomplete-btn {
    font-size: 16px;
  }

  ul {
    justify-content: space-between;
    width: 95%;
  }

  .reminder-card {
    height: 50px;
  }

  .type {
    line-height: normal;
  }

  .time {
    line-height: normal;
  }

  .save-changes-btn {
    font-size: 8px;
  }

  input {
    font-size: 8px;
    height: 36px;
  }
}

@media (max-width: 630px) {
  button {
    font-size: 12px;
  }

  .complete-btn {
    font-size: 12px;
  }
  .incomplete-btn {
    font-size: 12px;
  }

  ul {
    justify-content: space-between;
    width: 95%;
  }

  .reminder-card {
    height: 40px;
  }

  .type {
    line-height: normal;
  }

  .time {
    line-height: normal;
  }

  .save-changes-btn {
    font-size: 4px;
  }

  input {
    font-size: 6px;
    height: 30px;
  }
}

@media (max-width: 470px) {
  button {
    font-size: 10px;
  }

  .complete-btn {
    font-size: 10px;
  }
  .incomplete-btn {
    font-size: 10px;
  }

  ul {
    justify-content: space-between;
    width: 95%;
  }

  .reminder-card {
    height: 35px;
  }

  .type {
    line-height: normal;
  }

  .time {
    line-height: normal;
  }

  .save-changes-btn {
    font-size: 3px;
  }

  input {
    font-size: 6px;
    height: 24px;
  }
}
</style>
