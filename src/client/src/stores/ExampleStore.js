import {
    observable, action
} from 'mobx';

export default class ExampleStore {

    constructor(root) {
        this.root = root;
    }

    @observable testData = "Test";

}