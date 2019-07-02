import {
    observable, action
} from 'mobx';

export default class ChatStore {

    constructor(root) {
        this.root = root;
    }

    @observable chatList = ["1", "2", "3"];

}