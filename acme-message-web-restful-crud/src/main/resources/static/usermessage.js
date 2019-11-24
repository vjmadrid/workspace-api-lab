var usermessages = [];

var API_MAPPING = 'http://localhost:8091/api/v1/usermessages/'

function findUserMessage (id) {
  return usermessages[findUserMessageKey(id)];
}

function findUserMessageKey (id) {
  for (var key = 0; key < usermessages.length; key++) {
    if (usermessages[key].id == id) {
      return key;
    }
  }
}

var userMessageService = {

  findAll(fn) {
    axios
      .get(API_MAPPING)
      .then(response => fn(response))
      .catch(error => console.log(error))
  },

  findById(id, fn) {
    axios
      .get(API_MAPPING + id)
      .then(response => fn(response))
      .catch(error => console.log(error))
  },

  create(usermessage, fn) {
    axios
      .post(API_MAPPING, usermessage)
      .then(response => fn(response))
      .catch(error => console.log(error))
  },

  update(id, usermessage, fn) {
    axios
      .put(API_MAPPING + id, usermessage)
      .then(response => fn(response))
      .catch(error => console.log(error))
  },

  delete(id, fn) {
    axios
      .delete(API_MAPPING + id)
      .then(response => fn(response))
      .catch(error => console.log(error))
  }

}

var UserMessageList = Vue.extend({
  template: '#usermessage-list',
  data: function () {
    return {usermessages: [], searchKey: ''};
  },
  computed: {
    filteredUserMessages() {
      return this.usermessages.filter((usermessage) => {
        return (usermessage.id == this.searchKey) > -1
          || usermessage.description.toString().indexOf(this.searchKey) > -1
          || usermessage.vip.toString().indexOf(this.searchKey) > -1
      })
    }
  },
  mounted() {
    userMessageService.findAll(r => {this.usermessages = r.data; usermessages = r.data})
  }
});

var UserMessage = Vue.extend({
  template: '#usermessage',
  data: function () {
    return {usermessage: findUserMessage(this.$route.params.id)};
  }
});

var AddUserMessage = Vue.extend({
  template: '#add-usermessage',
  data() {
    return {
      usermessage: {id: -1, description: '', vip: false}
    }
  },
  methods: {
    createUserMessage() {
      userMessageService.create(this.usermessage, r => router.push('/'))
    }
  }
});

var EditUserMessage = Vue.extend({
  template: '#edit-usermessage',
  data: function () {
    return {usermessage: findUserMessage(this.$route.params.id)};
  },
  methods: {
    updateUserMessage: function () {
      userMessageService.update(this.usermessage.id, this.usermessage, r => router.push('/'))
    }
  }
});

var DeleteUserMessage = Vue.extend({
  template: '#delete-usermessage',
  data: function () {
    return {usermessage: findUserMessage(this.$route.params.id)};
  },
  methods: {
    deleteUserMessage: function () {
      userMessageService.delete(this.usermessage.id, r => router.push('/'))
    }
  }
});

var router = new VueRouter({
	routes: [
		{path: '/', component: UserMessageList},
		{path: '/usermessages/:id', component: UserMessage, name: 'usermessage'},
    {path: '/add-usermessage', component: AddUserMessage},
    {path: '/usermessages/:id/edit', component: EditUserMessage, name: 'edit-usermessage'},
    {path: '/usermessages/:id/delete', component: DeleteUserMessage, name: 'delete-usermessage'}
  ]
});

new Vue({
  router
}).$mount('#acme-app')