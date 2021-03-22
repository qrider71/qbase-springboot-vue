<template>
  <div class="form-group">
    <h1>Ping</h1>
    <div class="input-form">
      <div class="input-fields">
        <label :class="getLabelStyleMessage()">Message
          <input :value="msg" @input="updateMessage($event)"/>
        </label>&nbsp;
        <label :class="getLabelStyleCount()">Count
          <input type="number" :value="count" @input="updateCount($event)"/>
        </label>
        <div class="div-button">
          <button type="submit" @click="submit">submit</button>
        </div>
      </div>
      <textarea readonly v-model="response"/>
      <div/>
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import axios from 'axios';

const AXIOS = axios.create({
  baseURL: '/api',
  timeout: 1000,
});

@Component
export default class PingView extends Vue {
  msg = 'Ping Message';

  count = 1;

  response = '';

  messageOk = true;

  countOk = true;

  mouseEvent?: MouseEvent;

  updateMessage($event: { target: { value: string } }): void {
    this.msg = $event.target.value;
  }

  updateCount($event: { target: { value: string } }): void {
    const countTemp = parseInt($event.target.value, 10);
    if (Number.isInteger(countTemp)) {
      this.count = countTemp;
      this.countOk = true;
    } else {
      this.count = 0;
      this.countOk = false;
    }
  }

  getLabelStyleMessage(): string {
    if (this.messageOk) {
      return 'label_ok';
    }
    return 'label_red';
  }

  getLabelStyleCount(): string {
    if (this.countOk) {
      return 'label_ok';
    }
    return 'label_red';
  }

  submit(x: MouseEvent): void {
    this.mouseEvent = x;
    console.log(`Mouse Event ${x}`);
    this.response = `Response:${this.msg}`;
    this.ping(this.msg, this.count)
      .then((response) => {
        this.response = JSON.stringify(response.data, null, 2);
      });
  }

  ping(message: string, count: number) {
    this.response = '';
    return AXIOS.get(`/ping?message=${this.msg}&repeat=${this.count}`);
  }
}
</script>

<style scoped>
.label_red {
  padding: 10px;
  border: 2px solid red;
}

.label_ok {
  padding: 10px;
  border: none;
  border: 1px solid darkgray;
}

button {
  padding: 10px 215px;
  margin-top: 20px;
}

textarea {
  margin-top: 10px;
  padding: 10px 10px;
  width: 450px;
  height: 10em;
  resize: none;
}

.form-group {
  color: #42b983;
}
</style>
