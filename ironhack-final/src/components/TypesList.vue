<script setup>
defineProps({
  types: Array,
  selectedType: String
})

const emit = defineEmits(['type-selected', 'urgent'])

const selectType = (type) => {
  emit('type-selected', type)
}

const filterUrgent = () => {
  emit('urgent')
}

const colorsArr = [
  '#BAE1FF', // Azul claro
  '#FFB3BA', // Rosa suave
  '#BAFFC9', // Verde menta suave
  '#FFDFBA', // Melocotón
  '#D2B4DE', // Lavanda
  '#FFFFBA', // Amarillo pálido
  '#FFC3A0', // Coral suave
  '#FF677D', // Rosa pálido
  '#D6EAF8', // Azul celeste
  '#FFE5B4', // Amarillo pastel
  '#A2DFF7', // Aqua suave
  '#B9FBC0' // Verde claro
]
</script>

<template>
  <aside class="menu">
    <h2>Mis listas:</h2>
    <ul>
      <li v-for="(type, index) in types" :key="index">
        <button
          @click="selectType(type)"
          class="type-button"
          :style="'background-color: ' + colorsArr[index]"
          :class="{ 'selected-type': selectedType === type }"
        >
          {{ type }}
        </button>
      </li>
      <li>
        <button @click="filterUrgent" class="urgent-button">Urgentes</button>
        <button @click="selectType(null)" class="view-all-button">Ver todos</button>
      </li>
    </ul>
  </aside>
</template>

<style scoped>
.menu {
  background-color: #2c3e50;
  padding: 20px;
  border-radius: 10px;
  width: 12vw;
  position: fixed;
  top: 115px;
  left: 55px;
  border: solid 2px rgb(173, 202, 201);
  box-shadow: 0px 8px 12px rgba(0, 0, 0, 0.3);
  z-index: 3;
  max-height: 60vh;
  overflow-y: auto;
}

.menu::-webkit-scrollbar {
  width: 8px;
}

.menu::-webkit-scrollbar-thumb {
  background-color: #34495e;
  border-radius: 10px;
}

.menu::-webkit-scrollbar-thumb:hover {
  background-color: #2c3e50;
}

h2 {
  margin-left: 12px;
  text-shadow:
    -1.5px -1.5px 0 black,
    1.5px -1.5px 0 black,
    -1.5px 1.5px 0 black,
    1.5px 1.5px 0 black;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  margin-bottom: 15px;
  text-align: center;
}

.type-button {
  color: #2c3e50;
  border: none;
  padding: 10px;
  border-radius: 5px;
  cursor: pointer;
  width: 90%;
  height: 50px;
  box-shadow: 0px 8px 12px rgba(0, 0, 0, 0.3);
}

.type-button::first-letter {
  text-transform: uppercase;
}

.view-all-button {
  background-color: #ffffff;
  color: #0f4856;
  border: none;
  margin: 5px;
  margin-top: 25px;
  padding: 10px;
  border-radius: 5px;
  cursor: pointer;
}

.urgent-button {
  background-color: #c03e3e;
  color: #ffffff;
  border: none;
  margin: 5px;
  margin-top: 25px;
  padding: 10px;
  border-radius: 5px;
  cursor: pointer;
  border: 1px solid white;
}

.type-button:hover {
  background-color: #2980b9;
}

.view-all-button:hover {
  background-color: #bed3e1;
}

.urgent-button:hover {
  background-color: #a33a3a;
}

.selected-type {
  outline: 2px solid white;
  outline-offset: 5px;
}

@media (max-width: 1036px) {
  .menu {
    left: 40px;
    padding: 10px;
  }

  h2 {
    margin-left: 3px;
    font-size: 18px;
  }
}
@media (max-width: 810px) {
  .menu {
    left: 25px;
    padding: 6px;
  }

  h2 {
    margin-left: 3px;
    font-size: 14px;
  }

  .type-button {
    font-size: 12px;
    height: auto;
  }

  .urgent-button {
    font-size: 12px;
    height: auto;
    width: 90%;
  }

  .view-all-button {
    font-size: 12px;
    height: auto;
  }
}

@media (max-width: 630px) {
  .menu {
    left: 15px;
    padding: 6px;
  }

  h2 {
    margin-left: 3px;
    font-size: 12px;
  }

  .type-button {
    font-size: 8px;
    height: auto;
  }

  .urgent-button {
    font-size: 7px;
    height: auto;
    padding-left: 2px;
    padding-right: 2px;
    width: 80%;
  }

  .view-all-button {
    font-size: 8px;
    height: auto;
  }
}

@media (max-width: 470px) {
  .menu {
    left: 15px;
    padding: 6px;
  }

  h2 {
    margin-left: 3px;
    font-size: 12px;
  }

  .type-button {
    font-size: 6px;
    height: auto;
  }

  .urgent-button {
    font-size: 6px;
    height: auto;
    padding-left: 2px;
    padding-right: 2px;
    width: 80%;
  }

  .view-all-button {
    font-size: 6px;
    height: auto;
  }
}
</style>
