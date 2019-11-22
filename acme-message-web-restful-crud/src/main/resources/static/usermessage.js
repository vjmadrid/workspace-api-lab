var usermessages = [];

var API_MAPPING = 'http://localhost:8091/api/v1/usermessages'

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
      .get(API_MAPPING+'/' + id)
      .then(response => fn(response))
      .catch(error => console.log(error))
  },

  create(usermessage, fn) {
    axios
      .post(API_MAPPING, usermessage)
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
    return {usermessages: findUserMessage(this.$route.params.id)};
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

var router = new VueRouter({
	routes: [
		{path: '/', component: UserMessageList},
		{path: '/usermessages/:id', component: UserMessage, name: 'usermessage'},
    {path: '/add-usermessage', component: AddUserMessage},
  ]
});

new Vue({
  router
}).$mount('#acme-app')