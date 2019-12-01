import ExampleStore from './ExampleStore';
import ChatStore from './ChatStore';

class RootStore {
    constructor() {
        this.example = new ExampleStore(this);
        this.chat = new ChatStore(this);
    }
}

export default RootStore;