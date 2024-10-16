<script setup>
import { ref, computed } from 'vue'
import ReminderComponent from '@/components/ReminderComponent.vue'
import TypesList from '@/components/TypesList.vue'
import NewReminderComponent from '@/components/NewReminderComponent.vue'
import { useReminderStore } from '@/stores/reminder'
import { watch } from 'vue'

const reminderStore = useReminderStore()

const types = ref([])

const updateTypesList = () => {
  types.value = [...new Set(reminderStore.reminders.map((item) => item.type.toLowerCase()))]
}

watch(
  () => reminderStore.reminders,
  () => {
    updateTypesList()
  }
)

const selectedType = ref(null)
const showCompleted = ref(false)
const showNewReminderForm = ref(false)
const showUrgentReminders = ref(false)

const filteredReminders = computed(() => {
  return reminderStore.reminders.filter((reminder) => {
    const matchesType = selectedType.value
      ? reminder.type.toLowerCase() === selectedType.value.toLowerCase()
      : true
    const matchesState = showCompleted.value || !reminder.state
    const reminderTime = new Date(reminder.time)
    const matchesUrgent = showUrgentReminders.value ? reminderTime < new Date() : true
    return matchesType && matchesState && matchesUrgent
  })
})

const handleTypeSelection = (type) => {
  selectedType.value = type
}

const toggleCompletedReminders = () => {
  showCompleted.value = !showCompleted.value
}

const isCompleted = (reminder) => {
  reminderStore.toggleReminderState(reminder.id)
}

const cancelNewReminder = () => {
  showNewReminderForm.value = false
}

const addNewReminder = (newReminder) => {
  newReminder.type = newReminder.type.toLowerCase()

  reminderStore.createReminder(newReminder)

  if (!types.value.includes(newReminder.type)) {
    types.value.push(newReminder.type)
  }

  showNewReminderForm.value = false
}

const deleteReminder = (reminder) => {
  reminderStore.deleteReminder(reminder.id)
}

const updateReminder = async (reminder) => {
  await reminderStore.updateReminder(reminder.id, reminder)
  updateTypesList()
}

const handleUrgentFilter = () => {
  showUrgentReminders.value = !showUrgentReminders.value
}

updateTypesList()
reminderStore.fetchReminders()
</script>

<template>
  <div class="home-container">
    <TypesList
      :types="types"
      :selected-type="selectedType"
      @type-selected="handleTypeSelection"
      @urgent="handleUrgentFilter"
    />
    <div class="reminders-container">
      <p v-if="filteredReminders.length === 0" class="no-reminders-message">
        Aquí no hay nada! Pulsa en "<u>Nuevo Recordatorio</u>" para crear un recordatorio o cambia
        los filtros aplicados
      </p>
      <ReminderComponent
        v-for="reminder in filteredReminders"
        :key="reminder.id"
        :id="reminder.id"
        :name="reminder.name"
        :time="reminder.time"
        :state="reminder.state"
        :type="reminder.type"
        @completed-toggle="isCompleted(reminder)"
        @delete="deleteReminder(reminder)"
        @update="(updatedReminder) => updateReminder({ ...reminder, ...updatedReminder })"
      />
      <NewReminderComponent
        v-if="showNewReminderForm"
        @add-reminder="addNewReminder"
        @cancel-creation="cancelNewReminder"
      />
      <div class="center">
        <button @click="toggleCompletedReminders" class="toggle-completed">
          {{ showCompleted ? 'Ocultar completados' : 'Mostrar completados' }}
        </button>
        <button @click="showNewReminderForm = true" class="new-reminder-button">
          Nuevo Recordatorio
        </button>
      </div>
    </div>
  </div>
</template>

<style scoped>
.home-container {
  display: flex;
  justify-content: space-between;
  background-color: #34495e;
  color: #ecf0f1;
  padding: 20px;
}

.reminders-container {
  width: 75%;
  margin: 0 auto;
  position: relative;
  left: 7vw;
  top: 70px;
}

.toggle-completed,
.new-reminder-button {
  background-color: #3498db;
  color: #ecf0f1;
  border: none;
  padding: 10px;
  border-radius: 5px;
  cursor: pointer;
  margin: 20px 10px;
}

.toggle-completed:hover,
.new-reminder-button:hover {
  background-color: #2980b9;
}

.center {
  text-align: center;
}

.no-reminders-message {
  text-align: center;
  font-size: 20px;
  margin-top: 75px;
  margin-bottom: 75px;
  padding: 40px;
  border: 2px solid white;
  border-radius: 12px;
}

@media (max-width: 1036px) {
  .reminders-container {
    font-size: 14px;
    left: 8vw;
  }
}
@media (max-width: 810px) {
  .reminders-container {
    font-size: 12px;
    left: 9vw;
  }

  .toggle-completed,
  .new-reminder-button {
    font-size: 12px;
  }
}

@media (max-width: 630px) {
  .reminders-container {
    font-size: 8px;
    left: 10vw;
  }

  .toggle-completed,
  .new-reminder-button {
    font-size: 8px;
  }
}

@media (max-width: 470px) {
  .reminders-container {
    font-size: 6px;
    left: 11vw;
  }

  .toggle-completed,
  .new-reminder-button {
    font-size: 6px;
  }
}
</style>
