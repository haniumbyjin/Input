import React from 'react';
import { Component } from "react";
import { observer, inject } from 'mobx-react';
import TextField from '@material-ui/core/TextField';
import { makeStyles, withStyles } from '@material-ui/core/styles';
import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';
import Avatar from '@material-ui/core/Avatar';
import Typography from '@material-ui/core/Typography';
import ScrollArea from 'react-scrollbar';

// var Scroll  = require('react-scroll');

const styles = theme => ({

  
  root: {
    flexGrow: 1,
  },
  paper: {
    height: 700,
    width: 500,
    margin: 10,
    paddingTop: 10
  },
  field: {
    marginTop: '70%',
    marginBottom: '10%',
    width: '90%',
    height: '10%',
  },
  chat_paper: {
    maxWidth: 400,
    margin: `${theme.spacing(1)}px auto`,
    padding: theme.spacing(2),
  },
  scroll_div: {
    height: 250
  }
});


@inject('stores')
@observer
class Meet extends Component{

  state = {
    value:'',
  }

  constructor(props) {
    super(props);

    
    this.state = {
      spacing : 2,
    }
  }

  sendmessage() {
    debugger;
    const  { chatList } = this.props.stores.chat;
    alert(this.state.value);
    chatList.push(this.state.value);
    this.setState(
      {
        value : ''
      }
    )
  }

  handleChange = (e) => {
    this.setState({
        [e.target.name]: e.target.value //각 name에 맞는 value값 대입
    })
  }

  

  render() {

    const { classes } = this.props;
    const  { chatList } = this.props.stores.chat;

    const layout = (
      <Grid container className={classes.root} spacing={2}>
      <Grid item xs={12}>
        <Grid container justify="center" spacing={this.spacing}>
          {/* {[0, 1, 2].map(value => ( */}
            <Grid item >
              <Paper className={classes.paper}>
                화상채팅
              </Paper>
            </Grid>
            <Grid item>
              <Paper className={classes.paper}>
              <ScrollArea
            speed={0.8}
            className="area"
            contentClassName="content"
            horizontal={false}
            > 
                <div className={classes.scroll_div}>
                  {chatList.map(value => (
                  <Paper className={classes.chat_paper}>
                  <Grid container wrap="nowrap" spacing={2}>
                    <Grid item>
                      <Avatar>Y</Avatar>
                    </Grid>
                    <Grid item xs zeroMinWidth>
                      <Typography noWrap>{value}</Typography>
                    </Grid>
                  </Grid>
                </Paper>
                ))}
                </div>
                </ScrollArea>
                <form onSubmit={this.sendMessage}>
              <TextField
              onKeyPress={(ev) => {
                console.log(`Pressed keyCode ${ev.key}`);
                if (ev.key === 'Enter') {
                  // Do code here
                  this.sendmessage();
                  ev.preventDefault();
                }
              }}
                className={classes.field}
                id="outlined-full-width"
                label="Chat"
                placeholder="Placeholder"
                fullWidth
                margin="normal"
                variant="outlined"
                InputLabelProps={{
                  shrink: true,
                }}
                name="value"
                value={this.state.value}
                onChange={this.handleChange}
              />
              </form>
             
                </Paper>
            </Grid>
          {/* ))} */}
        </Grid>
      </Grid>
      
    </Grid>
    );

      
    return (
      
      <div>
          "Meet" page <br/>
          {layout}
          
      </div>
    );
  }
}



// export default Meet;
export default withStyles(styles)(Meet);
