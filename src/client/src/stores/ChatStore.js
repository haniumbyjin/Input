import {
    observable, action
} from 'mobx';

export default class ChatStore {

    constructor(root) {
        this.root = root;
    }

    userId = "yunjae";

    @observable chatList = [];

}