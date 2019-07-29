import React from 'react';
import { Component } from "react";
import { observer, inject } from 'mobx-react';
import TextField from '@material-ui/core/TextField';
import { makeStyles, withStyles } from '@material-ui/core/styles';
import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';
import Avatar from '@material-ui/core/Avatar';
import Typography from '@material-ui/core/Typography';
import InfiniteScroll from 'react-infinite-scroll-component';

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
    marginTop: '10%',
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
    height: 550
  }
});


@inject('stores')
@observer
class Meet extends Component {

  state = {
    value: '',
    fetchData: 10,
  }

  constructor(props) {
    super(props);


    this.state = {
      spacing: 2,
    }
  }

  sendmessage() {
    debugger;
    const { chatList } = this.props.stores.chat;
    alert(this.state.value);
    chatList.push(this.state.value);
    this.setState(
      {
        value: ''
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
    const { chatList } = this.props.stores.chat;

    const chatting = (
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
    )

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
             
                <InfiniteScroll
                  throttle={100}
                  threshold={300}
                  // dataLength={chatList.length} //This is important field to render the next data
                  next={this.state.fetchData}
                  hasMore={true}
                  // loader={<h4>Loading...</h4>}
                  endMessage={
                    <p style={{ textAlign: 'center' }}>
                      <b>Yay! You have seen it all</b>
                    </p>
                  }
                  initialScrollY={0}
                  // below props only if you need pull down functionality
                  refreshFunction={this.refresh}
                // pullDownToRefresh
                // pullDownToRefreshContent={
                //   <h3 style={{ textAlign: 'center' }}>&#8595; Pull down to refresh</h3>
                // }
                // releaseToRefreshContent={
                //   <h3 style={{ textAlign: 'center' }}>&#8593; Release to refresh</h3>
                // }
                >

                  {chatting}

                    
                </InfiniteScroll>
                

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
        "Meet" page <br />
        {layout}

      </div>
    );
  }
}



// export default Meet;
export default withStyles(styles)(Meet);
