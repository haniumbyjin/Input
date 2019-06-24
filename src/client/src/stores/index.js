import ExampleStore from './ExampleStore';

class RootStore {
    constructor() {
        this.example = new ExampleStore(this);
    }
}

export default RootStore;