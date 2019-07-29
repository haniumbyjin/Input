import {
    observable, action
} from 'mobx';

export default class ChatStore {

    constructor(root) {
        this.root = root;
    }

    @observable chatList = ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14"];

}